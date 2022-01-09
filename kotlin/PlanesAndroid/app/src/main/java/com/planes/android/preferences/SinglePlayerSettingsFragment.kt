package com.planes.android.preferences

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.planes.android.ApplicationScreens
import com.planes.android.MainActivity
import com.planes.android.databinding.FragmentOptionsBinding
import com.planes.android.R

class SinglePlayerSettingsFragment : Fragment() {
    private lateinit var binding: FragmentOptionsBinding
    private var m_InitialComputerSkill = 0
    private var m_InitialShowPlaneAfterKill = false
    private var m_InitialMultiplayerVersion = false
    private var m_PreferencesService = SinglePlayerPreferencesServiceGlobal()
    private var m_MainPreferencesService = MainPreferencesServiceGlobal()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        m_PreferencesService.createPreferencesService(context)
        m_MainPreferencesService.createPreferencesService(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOptionsBinding.inflate(layoutInflater, container, false)
        m_InitialComputerSkill = m_PreferencesService.computerSkill
        m_InitialShowPlaneAfterKill = m_PreferencesService.showPlaneAfterKill
        m_InitialMultiplayerVersion = m_MainPreferencesService.multiplayerVersion
        binding.settingsData = SinglePlayerSettingsViewModel(m_InitialComputerSkill, m_InitialShowPlaneAfterKill, m_InitialMultiplayerVersion)
        (activity as MainActivity).setActionBarTitle(getString(R.string.options))
        (activity as MainActivity).setCurrentFragmentId(ApplicationScreens.Preferences)
        var saveSettingsButton = binding.root.findViewById(R.id.options_savesettings) as Button
        if (saveSettingsButton != null) {
            saveSettingsButton.setOnClickListener(View.OnClickListener { writeToPreferencesService() })
        }

        return binding.root
    }

    override fun onDetach () {
        super.onDetach()
    }

    override fun onPause() {
        super.onPause()
    }

    fun writeToPreferencesService() {

        /*
            if multiplayerVersion check connection to server, then set multiplayerVersion in MainPreferencesService
        */

        if (this::binding.isInitialized) {
            if (!(activity as MainActivity).setOptions(
                    binding.settingsData!!.m_ComputerSkill,
                    binding.settingsData!!.m_ShowPlaneAfterKill
                )
            ) {
                binding.settingsData!!.m_ComputerSkill = m_InitialComputerSkill
                binding.settingsData!!.m_ShowPlaneAfterKill = m_InitialShowPlaneAfterKill
                binding.invalidateAll()
            }
        }
    }
}