import http from "../http-common"
import axios from "axios";

export default function uploadFileService(file, onUploadProgress) {
        let formData = new FormData();

        formData.append("file", file);

        return axios.post("http://localhost:8080/file/upload", formData, {
            headers: {
                "Content-Type": "multipart/form-data",
            },
            onUploadProgress,
        });

}