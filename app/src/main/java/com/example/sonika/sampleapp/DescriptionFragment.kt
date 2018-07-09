package com.example.sonika.sampleapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_description.*


class DescriptionFragment : Fragment() {
    // TODO: Rename and change types of parameters'

     var listItem: ListItem? = null
    var name: String? = null

    companion object {
        fun newInstance(item: ListItem):DescriptionFragment{
            val fragment = DescriptionFragment()
            fragment.listItem = item
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_description, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //val listItem= arguments!!.getSerializable("key") as ListItem
        //name = "asdfasdf"
        tv_description.setText(listItem?.description)
        tv_name.setText(listItem?.name)
        tv_address.setText(listItem?.address)





    }




}