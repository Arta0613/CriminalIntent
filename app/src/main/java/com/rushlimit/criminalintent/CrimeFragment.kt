package com.rushlimit.criminalintent

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rushlimit.criminalintent.model.Crime
import kotlinx.android.synthetic.main.fragment_crime.view.*

class CrimeFragment : Fragment() {

    var crime: Crime? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        crime = Crime()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val rootView = inflater.inflate(R.layout.fragment_crime, container, false)

        rootView.crime_title.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                crime?.title = s.toString()
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        rootView.crime_date.text = crime?.date.toString()
        rootView.crime_date.isEnabled = false

        rootView.crime_solved.setOnCheckedChangeListener { _, isChecked -> crime?.solved = isChecked }

        return rootView
    }
}