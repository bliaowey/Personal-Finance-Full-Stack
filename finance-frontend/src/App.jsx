import { Toolbar } from '@mui/material'
import './App.css'
import AddTransaction from './components/AddTransaction'
import Dashboard from './components/Dashboard'
import Header from './components/Header'
import Sidebar from './components/Sidebar'
import HomePage from './components/HomePage'
import Transactions from './components/Transactions'
import { BrowserRouter, Routes, Route } from 'react-router-dom'

function App() {

  return (
    <>
      <BrowserRouter>
        <Header />
        <Sidebar />
        {/* <Dashboard /> */}
        <Routes>
          {/* //http://localhost:3000 */}
          <Route path='/' element = { <HomePage />}></Route>
          {/* //http://localhost:3000/add-transaction */}
          <Route path='/add-transaction' element = {<AddTransaction />}></Route>
          {/* http://localhost:3000/all-transactions */}
          <Route path='/all-transactions' element = {<Transactions />}></Route>
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
