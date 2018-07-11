type TfLiteErrorHandler = (err: any) => any;
type TfLiteSuccessHandler = (data: any) => any;

interface TfLiteOptions {
  base64Img?: string;
}


interface TfLite {
  takePicture(options?:TfLiteOptions|TfLiteSuccessHandler, onSuccess?:TfLiteSuccessHandler|TfLiteErrorHandler, onError?:TfLiteErrorHandler):void;
  }
