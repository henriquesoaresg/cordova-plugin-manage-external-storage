# cordova-plugin-manage-external-storage
## About
This plugin was created to check the MANAGE_EXTERNAL_STORAGE permission and open the configuration screen to "Allow access to manage all files," which exists from Android API 30 onwards.
## Install
```
cordova plugin add https://github.com/henriquesoaresg/cordova-plugin-manage-external-storage
```
## Uninstall
```
cordova plugin rm cordova-plugin-manage-external-storage
```
## Example usage
```javascript
let hasPermission = false;

function checkPermission(){
    cordova.plugins.manageexternalstorage.checkPermission(resp => {
        hasPermission = (resp === cordova.plugins.manageexternalstorage.PERMISSION_GRANTED);
    });
}

function openAndroidConfig(){
    cordova.plugins.manageexternalstorage.openConfigPermissionScreen();
}
```