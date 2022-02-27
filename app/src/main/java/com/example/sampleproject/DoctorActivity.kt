package com.example.sampleproject

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sampleproject.databinding.ActivityDoctorBinding

class DoctorActivity : AppCompatActivity() {
    lateinit var binding: ActivityDoctorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityDoctorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViwes()
        gotoPatientDetail()

    }

    private fun gotoPatientDetail() {

    }

    fun initViwes(){
        var doc = intent.getParcelableExtra<Doctor>("doctor")
        binding.nameBox.text = doc?.name
        binding.statusView.text = doc?.onlineStatus.toString()
        binding.MedicalSpeciality.text = doc?.field
        title = doc?.name
        binding.call.setOnClickListener{
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.data = Uri.parse("tel:${doc?.phoneNumber}")
            startActivity(callIntent)
        }


        binding.clconsult1.setOnClickListener{
            Toast.makeText(this, "شما مدل مشاوره خود را انتخاب کردید.", Toast.LENGTH_SHORT).show()
            var intent = Intent(this, PatientInfo::class.java)
            var bundle = Bundle()
            bundle.putInt("id",doc!!.id)
            bundle.putString("name",doc!!.name)
            intent.putExtra("bundle", bundle)
            startActivity(intent)

        }
        binding.clconsult2.setOnClickListener{
            Toast.makeText(this, "شما مدل مشاوره خود را انتخاب کردید.", Toast.LENGTH_SHORT).show()
            var intent = Intent(this, PatientInfo::class.java)
            var bundle = Bundle()
            bundle.putInt("id",doc!!.id)
            bundle.putString("name",doc!!.name)
            intent.putExtra("bundle", bundle)
            startActivity(intent)

        }
        binding.clconsult3.setOnClickListener{
            Toast.makeText(this, "شما مدل مشاوره خود را انتخاب کردید.", Toast.LENGTH_SHORT).show()
            var intent = Intent(this, PatientInfo::class.java)
            var bundle = Bundle()
            bundle.putInt("id",doc!!.id)
            bundle.putString("name",doc!!.name)
            intent.putExtra("bundle", bundle)
            startActivity(intent)

        }


        var consult1 = Hospital.consultancyList[0]
        binding.tenMin.text = " مشاوره تلفنی ${consult1.time} دقیقه ای "
        binding.tenPrice.text = consult1.price.toString()+ " تومان"

        var consult2 = Hospital.consultancyList[1]
        binding.thirtyMin.text = " مشاوره تصویری ${consult2.time} دقیقه ای "
        binding.thirtyPrice.text = consult2.price.toString() + "تومان "

        var consult3 = Hospital.consultancyList[2]
        binding.sixtyMin.text = " مشاوره تلفنی ${consult3.time} دقیقه ای "
        binding.sixtyPrice.text = consult3.price.toString() + " تومان"
    }

}