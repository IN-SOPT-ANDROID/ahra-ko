package org.sopt.sample

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import org.sopt.sample.User.UserAdapter
import org.sopt.sample.databinding.FragmentHomeBinding
import org.sopt.sample.User.UserViewModel
import org.sopt.sample.remote.api.ResponseUser
import org.sopt.sample.remote.api.UserServicePool
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {
    private val userService = UserServicePool.userService
    private val userViewModel by viewModels<UserViewModel>()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = requireNotNull(_binding) { "여기서 오류" }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        userService.getUser().enqueue(object : Callback<ResponseUser>{
            override fun onResponse(call: Call<ResponseUser>, response: Response<ResponseUser>) {
                if (response.isSuccessful) {
                    userViewModel.userList.addAll(response.body()?.data!!)

                    val adapter = UserAdapter(requireContext())
                    binding.rvHome.adapter = adapter
                    adapter.setRepoList(userViewModel.userList)
                    Log.e("Response", "onResponse: ${userViewModel.userList}" )

                } else if (response.code() == 404) {
                    Snackbar.make(binding.root, "404 error", Snackbar.LENGTH_LONG)
                        .show()
                } else if (response.code() == 401) {
                    Snackbar.make(binding.root, "401 error", Snackbar.LENGTH_LONG)
                        .show()
                }
            }

            override fun onFailure(call: Call<ResponseUser>, t: Throwable) {
                Snackbar.make(binding.root, "서버 통신 장애가 발생", Snackbar.LENGTH_LONG).show()
            }
        })
    }
}
