import * as React from 'react';
import { useState } from "react";
import { Container } from '@mui/material';
import Title from '../Title';
import { signup } from '../../services/authentication/AuthenticationService';
import { useNavigate } from 'react-router-dom';

export default function SignUp() {
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();

    function saveUser(e) {
        e.preventDefault();

        signup(firstName, lastName, email, password).then((response) => {
            console.log(response.data);
        })

        navigate('/home');

    }

    return (
        <React.Fragment>
            <Container maxWidth="lg" sx={{ mt: 10, mb: 4 }}>
                <div className='row'>
                    <div className='card'>
                        <Title>Sign Up</Title>
                        <div className='card-body'>
                            <form>
                                <div className='form-group mb-2'>
                                    <label className='form-label'>First Name</label>
                                    <input
                                        type='text'
                                        placeholder='Enter First Name'
                                        value={firstName}
                                        className='form-control'
                                        onChange={(e) => setFirstName(e.target.value)}
                                    >
                                    </input>
                                </div>
                                <div className='form-group mb-2'>
                                    <label className='form-label'>Last Name</label>
                                    <input
                                        type='text'
                                        placeholder='Enter Last Name'
                                        value={lastName}
                                        className='form-control'
                                        onChange={(e) => setLastName(e.target.value)}
                                    >
                                    </input>
                                </div>
                                <div className='form-group mb-2'>
                                    <label className='form-label'>Email</label>
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
                                    <label className='form-label'>Password</label>
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
                        <button className='btn btn-primary mb-2' onClick={saveUser}>Sign Up</button>
                    </div>
                </div>
            </Container>
        </React.Fragment>
    );
}