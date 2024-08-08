import { Toolbar } from '@mui/material'
import './App.css'
import AddTransaction from './components/AddTransaction'
import Dashboard from './components/Dashboard'
import Header from './components/Header'
import Sidebar from './components/Sidebar'
import HomePage from './components/HomePage'
import Transactions from './components/Transactions'
import Box from '@mui/material/Box';
import CssBaseline from '@mui/material/CssBaseline';
import Typography from '@mui/material/Typography';
import Link from '@mui/material/Link';
import { BrowserRouter, Routes, Route } from 'react-router-dom'

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
              {/* //http://localhost:3000 */}
              <Route path='/' element = { <HomePage />}></Route>
              {/* //http://localhost:3000/add-transaction */}
              <Route path='/add-transaction' element = {<AddTransaction />}></Route>
              {/* http://localhost:3000/all-transactions */}
              <Route path='/all-transactions' element = {<Transactions />}></Route>
            </Routes>
          </Box>
        <Copyright sx={{ pt: 4 }} />
      </BrowserRouter>
    </>
  )
}

export default App
