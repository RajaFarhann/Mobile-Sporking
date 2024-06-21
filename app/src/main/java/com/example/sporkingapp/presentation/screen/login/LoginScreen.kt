package com.example.sporkingapp.presentation.screen.login

import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.sporkingapp.data.local.datastore.DataStore
import com.example.sporkingapp.data.local.sharedpreferences.SharedPreferencesManager
import com.example.sporkingapp.model.login.LoginViewModel
import com.example.sporkingapp.navigation.Screen
import com.example.sporkingapp.presentation.screen.login.component.LoginContent
import com.example.sporkingapp.utils.Constant.CLIENT
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel()
){
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val state = viewModel.state.collectAsState(initial = null)
    val sharedPreferencesManager = remember { SharedPreferencesManager(context) }
    val dataStore = DataStore(context)
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordConfirm by remember { mutableStateOf("") }
    var isRegistering by remember { mutableStateOf(false) }
    val googleLoginState = viewModel.stateGoogle.value


    @Suppress("DEPRECATION")
    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) {
            val account = GoogleSignIn.getSignedInAccountFromIntent(it.data)
            try{
                val result = account.getResult(ApiException::class.java)
                val credential = GoogleAuthProvider.getCredential(result.idToken, null)
                viewModel.loginWithGoogle(credential) {
                    navController.navigate(Screen.Beranda.route) {
                        popUpTo(Screen.Login.route) {
                            inclusive = true
                        }
                    }
                }
            } catch (it: ApiException) {
                Toast.makeText(context, "$it", Toast.LENGTH_SHORT).show()
            }
        }

    Box(modifier = Modifier.fillMaxSize()) {
        LoginContent(
            name = name,
            email = email,
            password = password,
            passwordConfirm = passwordConfirm,
            onNameChange = { name = it },
            onEmailChange = { email = it },
            onPasswordChange = { password = it },
            onPasswordConfirmChange = { passwordConfirm = it },
            onLoginClick = {
                coroutineScope.launch {
                    if (email.isBlank() || password.isBlank()) {
                        Toast.makeText(
                            context,
                            "Email dan Password wajib diisi",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        sharedPreferencesManager.email = name
                        sharedPreferencesManager.password = password
                        coroutineScope.launch {
                            dataStore.saveStatus(true)
                        }
                        viewModel.loginUser(email, password) {
                            navController.navigate(Screen.Beranda.route) {
                                popUpTo(Screen.Login.route) {
                                    inclusive = true
                                }
                            }
                            email = ""
                            password = ""
                        }
                    }
                }
            },
            moveToForget = {
                Toast.makeText(
                    context,
                    "Forgot Password is still in progress",
                    Toast.LENGTH_SHORT
                ).show()
            },
            onGoogleClick = {
                val googleLogin = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestEmail()
                    .requestIdToken(CLIENT)
                    .build()

                @Suppress("DEPRECATION")
                val googleLoginClient = GoogleSignIn.getClient(context, googleLogin)
                launcher.launch(googleLoginClient.signInIntent)
            },
            onRegisterClick = {
                coroutineScope.launch {
                    if (email.isBlank() || password.isBlank()) {
                        Toast.makeText(
                            context,
                            "Email dan Password Wajib Diisi",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    } else if (password != passwordConfirm) {
                        Toast.makeText(
                            context,
                            "Password dan Konfirmasi Password tidak cocok",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        viewModel.registerUser(name, email, password) {
                            navController.navigate(Screen.Beranda.route) {
                                popUpTo(Screen.Login.route) { inclusive = true }
                            }
                            name = ""
                            email = ""
                            password = ""
                            passwordConfirm = ""
                        }
                    }
                }
            },
            toggleAuthMode = { isRegistering = !isRegistering },
            isRegistering = isRegistering,
            modifier = modifier
        )
        LaunchedEffect(key1 = state.value?.success) {
            coroutineScope.launch {
                if (state.value?.success?.isNotEmpty() == true) {
                    val success = state.value?.success
                    Toast.makeText(context, "$success", Toast.LENGTH_SHORT).show()
                }
            }
        }
        LaunchedEffect(key1 = state.value?.error) {
            coroutineScope.launch {
                if (state.value?.error?.isNotEmpty() == true) {
                    val error = state.value?.error
                    Toast.makeText(context, "$error", Toast.LENGTH_SHORT).show()
                }
            }
        }
        LaunchedEffect(key1 = googleLoginState.success) {
            coroutineScope.launch {
                if (googleLoginState.success != null) {
                    Toast.makeText(context, "Login With Google Success", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}