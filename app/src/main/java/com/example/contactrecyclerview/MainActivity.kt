package com.example.contactrecyclerview

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var contactAdapter: RecyclerContactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val arrContacts = ArrayList<ContactModel>().apply {
            add(ContactModel(R.drawable.avatar_1, "Dipesh", "9867990635"))
            add(ContactModel(R.drawable.avatar_2, "Sachin", "9867990635"))
            add(ContactModel(R.drawable.avatar_3, "Sapna", "9867990635"))
            add(ContactModel(R.drawable.avatar_4, "Deepak", "9867990635"))
            add(ContactModel(R.drawable.avatar_5, "Kushboo", "9867990635"))
            add(ContactModel(R.drawable.avatar_6, "Manish", "9867990635"))
            add(ContactModel(R.drawable.avatar_7, "Pawan", "9867990635"))
            add(ContactModel(R.drawable.avatar_8, "Navin", "9867990635"))

        }

        binding.rcContactView.layoutManager = LinearLayoutManager(this@MainActivity)

        contactAdapter = RecyclerContactAdapter(this@MainActivity, arrContacts)

        binding.rcContactView.adapter = contactAdapter

        binding.fabAdd.setOnClickListener {

            val addDialog = Dialog(this@MainActivity).apply {
                setContentView(R.layout.contact_add)
                setCancelable(false)

                val edtContactName = findViewById<TextView>(R.id.edtContactName)
                val edtContactNumber = findViewById<TextView>(R.id.edtContactNumber)
                val btnAdd = findViewById<Button>(R.id.btnAdd)
                val btnCancel = findViewById<Button>(R.id.btnCancel)

                btnAdd.setOnClickListener {
                    val contactName = edtContactName.text.toString()
                    val contactNumber = edtContactNumber.text.toString()

                    if (contactName.isNotBlank() && contactNumber.isNotBlank()) {
                        arrContacts.add(
                            ContactModel(
                                R.drawable.ic_launcher_background,
                                contactName,
                                contactNumber
                            )
                        )
                        contactAdapter.notifyItemInserted(arrContacts.size - 1)
                        binding.rcContactView.scrollToPosition(arrContacts.size - 1)

                    }

                    dismiss()

                }

                btnCancel.setOnClickListener {
                    dismiss()
                }
            }

            addDialog.show()

        }

    }
}