package com.example.caffe_app.main.setting

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.caffe_app.LoginActivity
import com.example.caffe_app.R
import com.example.caffe_app.basic_listview.ListAdapter
import com.example.caffe_app.main.MainActivity
import com.example.caffe_app.main.setting.setting_menu.LaporanSetting
import com.example.caffe_app.main.setting.setting_menu.MenuSetting
import com.example.caffe_app.main.setting.setting_menu.PrinterSetting
import com.example.caffe_app.main.setting.setting_menu.QrCodeSetting

class SettingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_setting, container, false)
        val sharedPref = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        val listView: ListView = view.findViewById(R.id.listView)

        val menuList = listOf(
            ListModel("Menu", "Kelola menu anda disini", R.drawable.baseline_restaurant_menu),
            ListModel("Laporan", "Lihat laporan penjualan", R.drawable.report),
            ListModel("Printer", "Hubungakan ke printer ", R.drawable.print),
            ListModel("QR Code", "Setting QR Code", R.drawable.qr_code_baseline),
            ListModel("Keluar", "Keluar dari aplikasi", R.drawable.logout),
        )

        val adapter = ListAdapter(requireActivity(), menuList)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = menuList[position]

            when (selectedItem.name) {
                "Menu" -> {
                    val menuSettingFragment = MenuSetting();
                    (activity as? MainActivity)?.replaceFragment(menuSettingFragment)
                }
                "Laporan" -> {
                    val laporanSettingFragment = LaporanSetting();
                    (activity as? MainActivity)?.replaceFragment(laporanSettingFragment)
                }
                "Printer" -> {
                    val printerSettingFragment = PrinterSetting();
                    (activity as? MainActivity)?.replaceFragment(printerSettingFragment)
                }
                "QR Code" -> {
                    val qrCodeSettingFragment = QrCodeSetting();
                    (activity as? MainActivity)?.replaceFragment(qrCodeSettingFragment)
                }
                "Keluar" -> {
                    logout(sharedPref)
                }
                else -> false
            }
        }

        return view
    }

    private fun logout(sharedPref : SharedPreferences) {
        AlertDialog.Builder(requireContext())
            .setTitle("Perhatian!")
            .setMessage("Apakah anda yakin untuk keluar?")
            .setPositiveButton("Yes") { dialogInterface, _ ->
                dialogInterface.dismiss()

                val editor = sharedPref.edit()
                editor.remove("isLogin")
                editor.apply()

                val i = Intent(requireActivity(), LoginActivity::class.java)
                i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                requireActivity().finish()

            }
            .setNegativeButton("No", null)
            .show()
    }
}
