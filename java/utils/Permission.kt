
object Permission{
    private fun checkAndRequestPermissions(): Boolean{
        val camera = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)

        val listPermissionsNeeded = ArrayList<String>()

        if (camera != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.CAMERA)
        }

        if (listPermissionsNeeded.isNotEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toTypedArray(), Constant.REQUEST_ID_MULTIPLE_PERMISSIONS)
            return false
        }

        return true
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when(requestCode){
            Constant.REQUEST_ID_MULTIPLE_PERMISSIONS -> {
                val perms = HashMap<String, Int>()
                perms[Manifest.permission.CAMERA] = PackageManager.PERMISSION_GRANTED

                if (grantResults.isNotEmpty()) {
                    for (i in permissions.indices) perms[permissions[i]] = grantResults[i]

                    if (perms[Manifest.permission.CAMERA] == PackageManager.PERMISSION_GRANTED) {
                        // do logic after granded permission
                    } else{
                        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                            AlertDialog.Builder(this)
                                .setMessage("Service Permissions are required for this app")
                                .setPositiveButton("OK") {_, _ -> checkAndRequestPermissions()}
                                .setNegativeButton("Cancel") {_, _ -> finish()}
                                .create()
                                .show()
                        } else {
                            AlertDialog.Builder(this)
                                .setMessage("You need to give some mandatory permissions to continue. Do you want to go to app settings?")
                                .setPositiveButton("Yes") { _, _ ->
                                    startActivity(Intent(
                                        android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                                        Uri.parse("package:com.shandysiswandi.goodworkshop")
                                    ))
                                }
                                .setNegativeButton("Cancel") { _, _ -> finish() }
                                .show()
                        }
                    }
                }
            }
        }
    }
}

