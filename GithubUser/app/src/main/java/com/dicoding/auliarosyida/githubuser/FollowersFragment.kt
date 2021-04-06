package com.dicoding.auliarosyida.githubuser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.dicoding.auliarosyida.githubuser.databinding.FragmentFollowersBinding
import com.dicoding.auliarosyida.githubuser.databinding.FragmentProfileBinding

class FollowersFragment : Fragment() {

//    private var _binding: FragmentFollowersBinding? = null
//    private val binding: FragmentFollowersBinding
//        get() = requireNotNull(_binding)

    private var users = mutableListOf<User>()
    private var listUserAdapter = UserAdapter(users)

    companion object {

        private const val ARG_SECTION_NUMBER = "section_number"
        private const val ARG_USERNAME = "username"

        @JvmStatic
        fun newInstance(index: Int, uname: String) =
                FollowersFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_SECTION_NUMBER, index)
                        putString(ARG_USERNAME, uname)
                    }
                }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_followers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvLabel: TextView = view.findViewById(R.id.section_label)
        val index = arguments?.getInt(ARG_SECTION_NUMBER, 0)
        tvLabel.text = getString(R.string.content_tab_text, index)
    }
}