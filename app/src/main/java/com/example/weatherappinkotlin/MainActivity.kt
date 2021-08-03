package com.example.weatherappinkotlin

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherappinkotlin.adapters.WeatherAdapter
import com.example.weatherappinkotlin.models.HourlyWeather.Hourly
import com.example.weatherappinkotlin.models.HourlyWeather.OpenWeatherResponse
import com.example.weatherappinkotlin.repositories.WeatherRepository
import com.example.weatherappinkotlin.retrofit.ApiInterface
import com.example.weatherappinkotlin.utility.Utility
import com.example.weatherappinkotlin.utility.Utility.hideProgress
import com.example.weatherappinkotlin.utility.Utility.showProgress
import com.example.weatherappinkotlin.viewmodels.MainActivityViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.OnSuccessListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MainActivity : AppCompatActivity() {

    private val RC_LOCATION = 1
    private val RC_PERM_SETTINGS = 2
//    private var binding: ViewDataBinding? = null
    private var mainActivityViewModel: MainActivityViewModel? = null
    private var weatherAdapter: WeatherAdapter? = null
    private var apiService: ApiInterface? = null
    private val APP_ID = "852ee7df693a3f8977dbaad7e9bce46a"
    private var weatherRepository: WeatherRepository? = null
    private var lat: Double? = null
    private var lon:kotlin.Double? = null
    private val locationManager: LocationManager? = null
    private val locationListener: LocationListener? = null
    private var context: Context? = null
    private var newList: List<Hourly>? = null
    private var rvList: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this

        newList = ArrayList<Hourly>()

        weatherRepository = WeatherRepository(application)
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        apiService = ApiClient.client!!.create(ApiInterface::class.java)
        initRecyclerView()

        checkForLocationPermission()

        mainActivityViewModel!!.getList().observe(this,
            Observer<List<Any?>?> { strings -> weatherAdapter!!.getList(strings as List<Hourly>) })
    }

    private fun checkForLocationPermission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ),
                RC_LOCATION
            )
        } else {
            callLocation()
        }
    }

    private fun callLocation() {
        val manager = getSystemService(LOCATION_SERVICE) as LocationManager
        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            buildAlertMessageNoGps()
        } else {
            getMyCoodinates()
        }
    }

    private fun getMyCoodinates() {

        val fusedLocationClient: FusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(this)

        fusedLocationClient.getLastLocation()
            .addOnSuccessListener{location: Location? ->
                    // Got last known location. In some rare situations this can be null.
                    if (location != null) {
                        // Logic to handle location object
                        lat = location.latitude
                        lon = location.longitude
                        getHourlyWeather()
                    }
                }
            .addOnFailureListener{ e: Exception ->
                    Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_SHORT).show()
                    e.printStackTrace()
                }
    }

    private fun buildAlertMessageNoGps() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Your GPS seems to be disabled, do you want to enable it?")
            .setCancelable(false)
            .setPositiveButton(
                "Yes"
            ) { dialog, id ->
                startActivityForResult(
                    Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS),
                    RC_PERM_SETTINGS
                )
            }
            .setNegativeButton(
                "No"
            ) { dialog, id -> dialog.cancel() }
        val alert = builder.create()
        alert.show()
    }

    private fun getHourlyWeather() {
        showProgress(context)
        apiService!!.getHourlyWeather(lat!!, lon!!, APP_ID, "metric")!!.enqueue(object : Callback<OpenWeatherResponse?> {
                override fun onResponse(
                    call: Call<OpenWeatherResponse?>,
                    response: Response<OpenWeatherResponse?>
                ) {
                    hideProgress()
                    Utility.CURRENT_TEMPERATURE =
                        java.lang.String.valueOf(response.body()!!.current!!.temp)
                    weatherRepository!!.insert(response.body()!!.hourly)
                }

                override fun onFailure(call: Call<OpenWeatherResponse?>, t: Throwable) {
                    hideProgress()
                    Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
                }
            })
    }

    private fun initRecyclerView() {
        rvList = findViewById(R.id.rvList)
        weatherAdapter = WeatherAdapter(this, mainActivityViewModel!!.getList().getValue())
        rvList!!.setLayoutManager(LinearLayoutManager(this))
        rvList!!.setAdapter(weatherAdapter)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_PERM_SETTINGS) {
            getMyCoodinates()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == RC_LOCATION && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            callLocation()
        }
    }
}