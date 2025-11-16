package otus.gpb.homework.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import otus.gpb.homework.fragments.databinding.FragmentBBinding

class FragmentB : Fragment() {

    private var _binding: FragmentBBinding? = null
    private val binding: FragmentBBinding
        get() = _binding ?: throw RuntimeException("FragmentAABinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (binding.containerFragmentB == null) {
            childFragmentManager.beginTransaction()
                .replace(R.id.containerFragmentBA, FragmentBA.newInstance())
                .commit()
            childFragmentManager.beginTransaction()
                .replace(R.id.containerFragmentBB, FragmentBB.newInstance())
                .commit()
        } else {
            childFragmentManager.beginTransaction()
                .replace(R.id.containerFragmentB, FragmentBA.newInstance())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        fun newInstance(): FragmentB{
            return FragmentB()
        }
    }
}
