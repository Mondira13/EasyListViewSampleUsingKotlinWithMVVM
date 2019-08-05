package com.example.easylistviewsampleusingkotlinwithmvvm.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.easylistviewsampleusingkotlinwithmvvm.R
import com.example.easylistviewsampleusingkotlinwithmvvm.model.Item
import com.example.easylistviewsampleusingkotlinwithmvvm.responses.DashboardResponse
import com.example.easylistviewsampleusingkotlinwithmvvm.viewmodel.SampleViewModel
import com.sayan.easylistwidget.EasyListView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var  sampleViewModel: SampleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initial value into view model reference variable
        sampleViewModel = ViewModelProviders.of(this).get(SampleViewModel::class.java)

        /**
         * load list of data from ViewModel
         */
        loadListOfDatas();
    }

    /**
     * load list of data from ViewModel
     */
    private fun loadListOfDatas() {
        sampleViewModel.getListOfData().observe(this, Observer<DashboardResponse> { response ->

            // if list is valid then set the value into EasyListView
            if(response.items != null){
                val easyListView = EasyListView.Builder<Item>(this@MainActivity)
                    .addItemModel(Item::class.java)
                    .addListItems(response.items)
                    .addRecyclerView(recyclerView)
                    .addRow(R.layout.recycle_layout)
                    .setOnItemClickListener(object : EasyListView.OnItemClickListener {
                        override fun onClick(view: View?, position: Int) {
                            if (view != null) {
                                if (view.id == R.id.parentLayout) {
                                    Toast.makeText(this@MainActivity,response.items.get(position).name,Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                    })
//                    .setOnBindViewHolderCalledListener(this)
                    .build()
            }
            // if list is inValid then show toast msg
            else{
                Toast.makeText(this,"No data available",Toast.LENGTH_SHORT).show()
            }
        }
        )
    }




}
