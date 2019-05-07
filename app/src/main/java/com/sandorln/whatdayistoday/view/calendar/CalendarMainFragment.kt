package com.sandorln.whatdayistoday.view.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.sandorln.whatdayistoday.databinding.FCalendarMainBinding
import com.sandorln.whatdayistoday.view.calendar.adapter.MonthAdapter
import com.sandorln.whatdayistoday.viewmodel.CalendarMainVM
import kotlinx.android.synthetic.main.f_calendar_main.*

class CalendarMainFragment : Fragment() {

    lateinit var binding: FCalendarMainBinding
    private val viewModel: CalendarMainVM by lazy { ViewModelProviders.of(this)[CalendarMainVM::class.java] }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FCalendarMainBinding.inflate(inflater, container, false)
        binding.vm = viewModel
        binding.act = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        vp_month.adapter = MonthAdapter(fragmentManager!!, viewModel)
    }
}