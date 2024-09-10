import React, { Component, useState } from "react";
import { Container } from '@mui/material';
import Title from "./Title";
import uploadFileService from "../services/UploadFileService";


export default function UploadFile() {
    const [selectedFile, setSelectedFile] = useState(null);
    const [currentFile, setCurrentFile] = useState(null);
    const [progress, setProgress] = useState(0);
    const [message, setMessage] = useState('');
    const [fileInfos, setFileInfos] = useState([]);
    
    function selectFile(e) {
        setSelectedFile(e.target.files[0]);
    }
    
    function upload() {
        setProgress(0);
        setCurrentFile(selectedFile);
    
        uploadFileService(selectedFile, (event) => {
            setProgress(Math.round((100 * event.loaded) / event.total));
        })
        .then((response) => {
            setMessage(response.data.message);
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
                        <div>
                            <p>
                                Files must have five columns for each of the record attributes (not including ID):
                            </p>
                            <ul>
                                <li>Column 1: Account Type</li>
                                <li>Column 2: Date</li>
                                <li>Column 3: Value</li>
                                <li>Column 4: Category Type</li>
                                <li>Column 5: Comments</li>
                            </ul>
                            <p>
                                Dates must be in <b>yyyy-MM-dd</b> format (For Example: 2024-09-06 would be September 6th, 2024).
                            </p>
                        </div>
                        <div className='card-body'>
                            {selectedFile && (
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
                                onClick={() => upload()}
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