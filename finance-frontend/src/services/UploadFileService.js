import http from "../http-common"

export default class UploadFileService {
    upload(file, onUploadProgress) {
        let formData = new FormData();

        formData.append("file", file);

        return http.post("/upload", formData, {
            headers: {
                "Content-Type": "multipart/form-data",
            },
            onUploadProgress,
        });
    }

    getFiles() {
        return http.get("/get-files");
    }
}