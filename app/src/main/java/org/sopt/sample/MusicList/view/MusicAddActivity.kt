package org.sopt.sample.MusicList.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.content.ContentProviderCompat.requireContext
import coil.load
import okhttp3.RequestBody
import org.sopt.sample.ContentUriRequestBody
import org.sopt.sample.Home.HomeActivity
import org.sopt.sample.MusicList.viewmodel.MusicAddViewModel
import org.sopt.sample.databinding.ActivityMusicAddBinding
import androidx.core.content.ContentProviderCompat.requireContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.sopt.sample.MainActivity

class MusicAddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMusicAddBinding
    private val viewModel by viewModels<MusicAddViewModel>()
    private val map: HashMap<String, RequestBody> = hashMapOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMusicAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivAlbum.setOnClickListener{
            imagePickerLauncher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageAndVideo))
        }

        binding.btnAdd.setOnClickListener{
            val title = binding.edtTitle.text.toString()
            val singer = binding.edtSinger.text.toString()

            map["request"] = "{\"title\": \"$title\", \"singer\": \"$singer\"}".toRequestBody("application/json".toMediaTypeOrNull())
            viewModel.addMusic(map)
            Toast.makeText(this@MusicAddActivity, "음악 추가 성공", Toast.LENGTH_SHORT).show()
        }

        binding.btnList.setOnClickListener{
            val intent = Intent(this@MusicAddActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


    private val imagePickerLauncher = registerForActivityResult(
        ActivityResultContracts.PickVisualMedia()
    ) {
        if (it != null) {
            binding.ivAlbum.load(it)
        } else {
            Log.d("PhotoPicker", "사진 선택 안댐..")
        }
    }



}