package org.sopt.sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.sopt.sample.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = requireNotNull(_binding) { "여기서 오류" }

    private val mockUserList = listOf<UserData>(
        UserData(
            image = R.drawable.ic_launcher_background,
            title = "컴퓨터",
            name = "computer"
        ),
        UserData(
            image = R.drawable.ic_launcher_background,
            title = "핸드폰",
            name = "smartphone"
        ),
        UserData(
            image = R.drawable.ic_launcher_background,
            title = "연필",
            name = "pencil"
        ),
        UserData(
            image = R.drawable.ic_launcher_background,
            title = "커피",
            name = "coffee"
        ),
        UserData(
            image = R.drawable.ic_launcher_background,
            title = "책상",
            name = "desk"
        ),
        UserData(
            image = R.drawable.ic_launcher_background,
            title = "의자",
            name = "chair"
        ),
        UserData(
            image = R.drawable.ic_launcher_background,
            title = "노래",
            name = "song"
        ),
        UserData(
            image = R.drawable.ic_launcher_background,
            title = "옷",
            name = "clothes"
        ),
        UserData(
            image = R.drawable.ic_launcher_background,
            title = "노트북",
            name = "notebook"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = HomeAdapter(requireContext())
        binding.rvHome.adapter = adapter
        adapter.setUserList(mockUserList)
    }
}
