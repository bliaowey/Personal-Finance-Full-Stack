import './App.css'
import AddTransaction from './components/AddTransaction'
import Header from './components/Header'
import Sidebar from './components/Sidebar'
import HomePage from './components/HomePage'
import Transactions from './components/Transactions'
import Box from '@mui/material/Box';
import CssBaseline from '@mui/material/CssBaseline';
import Typography from '@mui/material/Typography';
import Link from '@mui/material/Link';
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import UploadFile from './components/UploadFile'
import SignUp from './components/Authentication/SignUp'
import Login from './components/Authentication/Login'
import WelcomePage from './components/WelcomePage'

function Copyright(props) {
  return (
    <Typography variant="body2" color="text.secondary" align="center" {...props}>
      {'Copyright © '}
      <Link color="inherit" href="https://mui.com/">
        Your Website
      </Link>{' '}
      {new Date().getFullYear()}
      {'.'}
    </Typography>
  );
}


function App() {

  return (
    <>
      <BrowserRouter>
        <Box sx={{ display: 'flex' }}>
            <CssBaseline />
            <Header />
            <Sidebar />
            <Routes>
              {/* http://localhost:3000/ */}
              <Route path='/' element = { <WelcomePage />}></Route>
              {/* http://localhost:3000/home */}
              <Route path='/home' element = { <HomePage />}></Route>
              {/* http://localhost:3000/add-transaction */}
              <Route path='/add-transaction' element = {<AddTransaction />}></Route>
              {/* http://localhost:3000/all-transactions */}
              <Route path='/all-transactions' element = {<Transactions />}></Route>
              {/* http://localhost:3000/upload-file */}
              <Route path='/upload-file' element = {<UploadFile />}></Route>
              {/* http://localhost:3000/sign-up */}
              <Route path='/sign-up' element = {<SignUp />}></Route>
              {/* http://localhost:3000/login */}
              <Route path='/login' element = {<Login />}></Route>
            </Routes>
          </Box>
        <Copyright sx={{ pt: 4 }} />
      </BrowserRouter>
    </>
  )
}

export default App
