import * as React from 'react';
import { useState } from "react";
import { Container } from '@mui/material';
import Title from '../Title';
import { login } from '../../services/authentication/AuthenticationService';
import { useNavigate } from 'react-router-dom';

export default function Login() {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();

    function signIn(e) {
        e.preventDefault();

        if (login(email, password)) {
            navigate('/home');
        } else {
            return new Error("Invalid Login Credentials");
        }
    }

    return (
        <React.Fragment>
            <Container maxWidth="lg" sx={{ mt: 10, mb: 4 }}>
                <div className='row'>
                    <div className='card'>
                        <Title>Login</Title>
                        <div className='card-body'>
                            <form>
                                <div className='form-group mb-2'>
                                    <label className='form-label'> Enter Email</label>
                                    <input
                                        type='text'
                                        placeholder='Enter Email'
                                        value={email}
                                        className='form-control'
                                        onChange={(e) => setEmail(e.target.value)}
                                    >
                                    </input>
                                </div>
                                <div className='form-group mb-2'>
                                    <label className='form-label'>Enter Password</label>
                                    <input
                                        type='text'
                                        placeholder='Enter Password'
                                        value={password}
                                        className='form-control'
                                        onChange={(e) => setPassword(e.target.value)}
                                    >
                                    </input>
                                </div>
                            </form>
                        </div>
                        <button className='btn btn-primary mb-2' onClick={signIn}>Login</button>
                    </div>
                </div>
            </Container>
        </React.Fragment>
    )
}