import * as React from 'react';
import { Container } from '@mui/material';
import Title from './Title';
import { useNavigate } from 'react-router-dom';

export default function WelcomePage() {
    const navigate = useNavigate();

    const handleSignUp = () => {navigate('/sign-up')};
    const handleLogin = () => {navigate('/login')};

    return (
        <React.Fragment>
            <Container maxWidth="lg" sx={{ mt: 10, mb: 4 }}>
                <div className='row'>
                    <div className='card'>
                        <Title>Welcome to the Personal Finance App!</Title>
                        <div className='card-body'>
                            <button className='btn btn-primary mb-2' onClick={handleSignUp}>Sign Up</button>
                            <button className='btn btn-primary mb-2' onClick={handleLogin}>Login</button>
                        </div>
                    </div>
                </div>
            </Container>
        </React.Fragment>
    )
}