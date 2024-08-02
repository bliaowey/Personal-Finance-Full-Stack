import './App.css'
import AddTransaction from './components/AddTransaction'
import Dashboard from './components/Dashboard'
import Header from './components/Header'
import { BrowserRouter, Routes, Route } from 'react-router-dom'

function App() {

  return (
    <>
      <BrowserRouter>
        <Header />
        <Routes>
          {/* //http://localhost:3000 */}
          <Route path='/' element = { <Dashboard />}></Route>
          {/* //http://localhost:3000/add-transaction */}
          <Route path='/add-transaction' element = {<AddTransaction />}></Route>
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
