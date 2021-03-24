package com.example.test_authen_firebase.ui.login

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.Observer
import com.example.test_authen_firebase.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginFragment : Fragment() {


    companion object {
        fun newInstance() = LoginFragment()
        const val RC_SIGN_IN = 202
    }

    private lateinit var mView: View
    private lateinit var viewModel: LoginViewModel
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mView = inflater.inflate(R.layout.login_fragment, container, false)
        return mView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(LoginViewModel::class.java)

        viewModel.user.observe(requireActivity(), Observer {
            it?.let { firebaseUser ->
                Log.d("Test login result:", firebaseUser.email ?: "")
            }
        })

        viewModel.login(requireActivity(), "test@mail.com", "12345678")
//        viewModel.register(requireActivity(), "test2@mail.com", "12345678z")
//        viewModel.register(requireActivity(), "test3@mail.com", "1234s5678z")

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)

        mView.findViewById<SignInButton>(R.id.sign_in_button).setOnClickListener {
            signIn()
        }

        mView.findViewById<AppCompatButton>(R.id.sign_out_button).setOnClickListener {
            viewModel.firebaseSignOut(googleSignInClient)
        }

        Firebase.auth.addAuthStateListener {
            it.currentUser?.let {firebaseUser ->
                Log.d("Login State", firebaseUser.email ?: "There are no email but login")
            } ?: run {
                Log.d("login State", "There are no User")
            }
        }
    }

    private fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!
                Log.d("Test Google Auth", "firebaseAuthWithGoogle:" + account.id)
                account.idToken?.let {
                    viewModel.firebaseAuthWithGoogle(requireActivity(), it)
                }

            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w("Test Google Auth", "Google sign in failed", e)
            }
        }
    }


}