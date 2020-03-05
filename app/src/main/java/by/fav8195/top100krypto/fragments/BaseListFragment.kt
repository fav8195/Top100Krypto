package by.fav8195.top100krypto.fragments

import android.os.Bundle
//import android.support.v4.app.Fragment //бажит
//import android.support.v7.widget.LinearLayoutManager //бажит
//import android.support.v7.widget.RecyclerView //бажит
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.fav8195.top100krypto.adapter.BaseAdapter
import kotlinx.android.synthetic.main.fragment_currencies_list.*

abstract class BaseListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    protected lateinit var viewAdapter: BaseAdapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewManager = LinearLayoutManager(context)
        viewAdapter = createAdapterInstance()

        recyclerView = list.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    abstract fun createAdapterInstance(): BaseAdapter<*>
}