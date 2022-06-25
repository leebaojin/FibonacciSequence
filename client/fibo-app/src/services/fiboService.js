import axios from "axios";

const REQUEST_URL = "http://localhost:8080/fibonacci";
const REQUEST_URL_CLOUD = "http://152.67.99.60:8080/fibonacci";
const REQUEST_URL_STRING = "http://localhost:8080/fibonacci/string";
const REQUEST_URL_CLOUD_STRING = "http://152.67.99.60:8080/fibonacci/string";
class fiboService{
    getFiboList(element){
        //The request must return a string as react.js is unable to process BigInteger, causing loss in precision
        return axios.post(REQUEST_URL_CLOUD_STRING, JSON.stringify({elements:element}), {
            headers: {
              // Overwrite Axios's automatically set Content-Type
              'Content-Type': 'application/json'
            }});
    }
}
export default new fiboService;