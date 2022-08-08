package com.example.androidpracticecode.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidpracticecode.databinding.FragmentFetchRecordBinding
import com.example.androidpracticecode.model.Data
import com.example.androidpracticecode.ui.BaseFragment
import com.example.androidpracticecode.utils.SessionManagement
import com.example.androidpracticecode.viewmodel.FetchRecordViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class FetchRecordFragment : BaseFragment() {

    @Inject
    lateinit var sessionManagement: SessionManagement
    private var count: Int = 0
    private val viewModel: FetchRecordViewModel by viewModels()
    var recordList = ArrayList<Data>()
    private lateinit var binding: FragmentFetchRecordBinding
    private lateinit var recordListAdapter : FetchRecordListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFetchRecordBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("onViewCreated","FetchRecordFragment")

    }

    override fun registerEvents() {

        recordListAdapter = FetchRecordListAdapter(recordList)
        binding.apply {
            rvFrList.apply {
                setHasFixedSize(true)
                layoutManager=
                    LinearLayoutManager(
                        this@FetchRecordFragment.activity,
                        LinearLayoutManager.VERTICAL,
                        false
                    )
                adapter=recordListAdapter
            }
            count=sessionManagement.getCount()
            openThiApp.text = "You Open This App $count"
            sessionManagement.updateCount(count+1)


            btnClick.setOnClickListener {

                CoroutineScope(Main).launch {
                    progressFetchRecord.visibility=View.VISIBLE
                    delay(3000) //this delay inserted deliberately
                    viewModel.getName()!!.observe(viewLifecycleOwner) { fetchRecordResult ->
                        recordList.clear()
                        recordList.addAll(fetchRecordResult.data)
                        recordListAdapter.notifyDataSetChanged()
                        progressFetchRecord.visibility=View.INVISIBLE
                    }
                }

            }

            clear.setOnClickListener {
                recordList.clear()
                recordListAdapter.notifyDataSetChanged()
            }
        }
    }
}