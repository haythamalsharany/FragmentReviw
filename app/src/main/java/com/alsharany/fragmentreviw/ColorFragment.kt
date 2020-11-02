package com.alsharany.fragmentreviw

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [ColorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ColorFragment : Fragment() {
    lateinit var sendBTN:Button
    var senddata:SendData?=null

 var myColor:String?=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myColor=arguments?.getString("color")as String
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_color, container, false)
        sendBTN=view.findViewById(R.id.send_btn)

        if(myColor=="red")
                 view.setBackgroundColor(Color.RED)
        else if(myColor=="blue")
            view.setBackgroundColor(Color.BLUE)
        // Inflate the layout for this fragment
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        senddata=context as SendData
    }

    override fun onDetach() {
        super.onDetach()
        senddata=null
    }

    override fun onStart() {
        super.onStart()
        sendBTN.setOnClickListener {
            senddata?.onSendData(myColor)



        }
    }

    companion object {


        @JvmStatic
        fun newInstance(color: String) =
            ColorFragment().apply {
                arguments = Bundle().apply {
                    putString("color",color)

                }
            }
    }
    interface SendData{
        fun onSendData(color:String?)
    }
}