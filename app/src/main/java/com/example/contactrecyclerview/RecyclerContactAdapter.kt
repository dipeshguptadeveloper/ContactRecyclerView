package com.example.contactrecyclerview

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerContactAdapter(val context: Context, val arrContact: ArrayList<ContactModel>) :
    RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgContactImage = itemView.findViewById<ImageView>(R.id.imgContactImage)
        val txtContactName = itemView.findViewById<TextView>(R.id.txtContactName)
        val txtContactNumber = itemView.findViewById<TextView>(R.id.txtContactNumber)
        val llRow = itemView.findViewById<LinearLayout>(R.id.llRow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.contact_row, parent, false))
    }

    override fun getItemCount(): Int {
        return arrContact.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imgContactImage.setImageResource(arrContact[position].contactImage)
        holder.txtContactName.text = arrContact[position].contactName
        holder.txtContactNumber.text = arrContact[position].contactNumber

        holder.llRow.setOnClickListener {
            val updateDialog = Dialog(context)
            updateDialog.setContentView(R.layout.contact_add)

            val txtTitle = updateDialog.findViewById<TextView>(R.id.txtTitle)
            val edtName = updateDialog.findViewById<EditText>(R.id.edtContactName)
            val edtNumber = updateDialog.findViewById<EditText>(R.id.edtContactNumber)
            val btnUpdate = updateDialog.findViewById<Button>(R.id.btnAdd)
            val btnCancel = updateDialog.findViewById<Button>(R.id.btnCancel)

            txtTitle.text = "Update Contact"
            edtName.setText(arrContact[position].contactName)
            edtNumber.setText(arrContact[position].contactNumber)
            btnUpdate.text = "Save"
            updateDialog.show()

        }
    }
}