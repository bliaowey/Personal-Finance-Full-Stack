import React, { Component, useState } from "react";
import { Container } from '@mui/material';
import Title from "./Title";
import uploadFileService from "../services/UploadFileService";


export default function UploadFile() {
    const [selectedFile, setSelectedFile] = useState([]);
    const [currentFile, setCurrentFile] = useState([]);
    const [progress, setProgress] = useState(0);
    const [message, setMessage] = useState('');
    const [fileInfos, setFileInfos] = useState([]);
    
    function selectFile(e) {
        // console.log("asdf");
        // console.log(e.target.files[0]);
        setSelectedFile(e.target.files);
        console.log(selectedFile);
    }
    
    function upload() {
        setProgress(0);
        setCurrentFile(selectedFile);
        console.log(selectedFile);
        console.log(currentFile);
    
        uploadFileService(currentFile, (event) => {
            setProgress(Math.round((100 * event.loaded) / event.total));
        })
        .then((response) => {
            setMessage(response.data.message);
        })
        .then((files) => {
            setFileInfos(files.data);
        })
        .catch(() => {
            setProgress(0);
            setMessage("Could not upload the file");
            setCurrentFile(null);
        });
    }

    return (
        <React.Fragment>
            <Container maxWidth="lg" sx={{ mt: 10, mb: 4 }}>
                <div className='row'>
                    <div className='card'>
                        <Title>Upload File</Title>
                        <div className='card-body'>
                            {currentFile && (
                                <div 
                                    className="progress-bar progress-bar-info progress-bar-striped"
                                    role="progressbar"
                                    aria-valuenow={progress}
                                    aria-valuemin={0}
                                    aria-valuemax={100}
                                    style={{ width: progress + "%"}}
                                >
                                    {progress}%
                                </div>
                            )}
                        </div>
                        <label className="btn btn-default">
                            <input type="file" onChange={(e) => selectFile(e)}/>
                        </label>
                        <button className='btn btn-success'
                                //disabled={!selectFile}
                                onClick={upload}
                        >
                            Upload
                        </button>
                        <div className="alert alert-light" role="alert">
                            {message}
                        </div>
                    </div>
                </div>
            </Container>
        </React.Fragment>
    );
}