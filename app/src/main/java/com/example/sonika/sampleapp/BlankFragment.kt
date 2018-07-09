package com.example.sonika.sampleapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_blank.*
import com.example.sonika.sampleapp.toast
import kotlinx.android.synthetic.main.adapter_sample.*


class BlankFragment : Fragment(), OnClickListener {
    override fun onClickListener(item: ListItem) {
        listItemClicked(item)

    }

    override fun onButtonClickListener(item: ListItem) {
       buttonclicked(item)
         }


    val information: ArrayList<ListItem> = ArrayList()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_blank, container, false)



        return view


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        information.add(ListItem("abc", "kalanki", "description1"))
        information.add(ListItem("abc1", "1kalanki", "description2"))
        information.add(ListItem("abc2", "2kalanki", "description3"))
        information.add(ListItem("abc3", "3kalanki", "description"))
        information.add(ListItem("abc4", "4kalanki", "description"))
        information.add(ListItem("abc5", "5kalanki", "description"))
        information.add(ListItem("abc", "kalanki", "description"))
        information.add(ListItem("abc1", "1kalanki", "description"))
        information.add(ListItem("abc3", "3kalanki", "description"))
        information.add(ListItem("abc4", "4kalanki", "description"))




        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)


//        recyclerView.adapter = AdapterSample(information, {
//            buttonclicked(it)
//        }, { listItemClicked(it) }
//        )


        recyclerView.adapter = AdapterSample(information, this)



    }




    private fun listItemClicked(item: ListItem) {
//        Toast.makeText(context, "Clicked: ${item.name}", Toast.LENGTH_LONG).show()
//        with extention
        context!!.toast("Clicked: ${item.name}")
        val fm = (context as AppCompatActivity).supportFragmentManager
        val ft = fm.beginTransaction()
        val farg = /*DescriptionFragment()*/DescriptionFragment.newInstance(item)
        /*val b= Bundle()
        b.putSerializable("key", item)
        farg.arguments=b*/

        ft.replace(R.id.container, farg)
        ft.addToBackStack(null)
        ft.commit()
    }

    private fun buttonclicked(item: ListItem) {
        Toast.makeText(context, "Clicked: ", Toast.LENGTH_LONG).show()

        context!!.toast("Clicked: ${item.name}")
        var textinsample = item.name
        tv_sample.text = textinsample


    }
}


