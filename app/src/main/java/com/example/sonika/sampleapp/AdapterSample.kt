package com.example.sonika.sampleapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.adapter_sample.view.*

//class AdapterSample (val items: List<ListItem>, val onClickListenr: (ListItem) -> Unit, val onButtonCLickListener : (ListItem) -> Unit) :
//RecyclerView.Adapter<ViewHolder>() {
class AdapterSample(val items: List<ListItem>, val onClickListenr: OnClickListener) :
        RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // LayoutInflater: takes ID from layout defined in XML.
        // Instantiates the layout XML into corresponding View objects.
        // Use context from main app -> also supplies theme layout values!
        val inflater = LayoutInflater.from(parent.context)
        // Inflate XML. Last parameter: don't immediately attach new view to the parent view group
        val view = inflater.inflate(R.layout.adapter_sample, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Populate ViewHolder with data that corresponds to the position in the list
        // which we are told to load

       // (holder as ViewHolder).bind(items[position], onClickListenr, onButtonCLickListener)
        (holder as ViewHolder).bind(items[position], onClickListenr)
    }


    override fun getItemCount() = items.size


}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

//    fun bind(information: ListItem, onclickListener: (ListItem) -> Unit, onbuttonClickListener : (ListItem) -> Unit) {
    fun bind(information: ListItem, clickListener: OnClickListener) {
        itemView.name.text = information.name
        itemView.address.text = information.address
        itemView.desc.text = information.description



        itemView.setOnClickListener {
            //            goes to adapter

//          clicklistener(information)
            clickListener.onClickListener(information)
        }

        itemView.btn_message.setOnClickListener(View.OnClickListener {
            //goes to adapter

//            onbuttonclicklistener(information)
            clickListener.onButtonClickListener(information)

        })


    }

//    extention
//    fragment access


}

//    val name = view.name
//    val address = view.address
//    val description =  view.description
//
//    val  view = itemView.setOnClickListener(this)
//
//
//
//
//    override fun onClick(view : View?) {
//
//        val fm = (context as AppCompatActivity).supportFragmentManager
//        val ft = fm.beginTransaction()
//        ft.replace(R.id.container, DescriptionFragment())
//        ft.commit()
//
//
//        Toast.makeText(itemView.context, name.text, Toast.LENGTH_SHORT).show()



