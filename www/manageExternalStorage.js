var manageExternalStorage = {
    PERMISSION_GRANTED: 1,
    PERMISSION_DENIED: 0,
    checkPermission: function (callback) {
        cordova.exec(callback, null, "ManageExternalStorage", "checkPermission", []);
    },
    openConfigPermissionScreen: function () {
        cordova.exec(null, null, "ManageExternalStorage", "openConfigPermissionScreen", []);
    }
}

module.exports = manageExternalStorage;