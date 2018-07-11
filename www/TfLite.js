var argscheck = require('cordova/argscheck'),
    utils = require('cordova/utils'),
    exec = require('cordova/exec');

var PLUGIN_NAME = "TfLite";

var TfLite = function() {};

function isFunction(obj) {
    return !!(obj && obj.constructor && obj.call && obj.apply);
};

TfLite.classifyFrameBase64 = function(options, onSuccess, onError) {
    options = options || {};
    options.base64Img = options.base64Img || 0;
   
    if (!isFunction(onSuccess)) {
        return false;
    }

    exec(onSuccess, onError, PLUGIN_NAME, "classifyFrameBase64", [options.base64Img]);
};


module.exports = TfLite;
