import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { ClienteTable } from './ClienteTable'
import { ClienteForm } from './ClienteForm'
import { ContaTable } from './ContaTable'
import { ContaForm } from './ContaForm'
import { AppBar, Button, Toolbar } from '@mui/material'

function App() {

  const [menu, setMenu] = useState(0)




  return (
    <>

    <AppBar position="static" className='full-width'>
      <Toolbar>
        <Button color="inherit" onClick={() => setMenu(0)}>Cadastrar Cliente</Button>
        <Button color="inherit" onClick={() => setMenu(1)}>Listar Cliente</Button>
        <Button color="inherit" onClick={() => setMenu(2)}>Cadastrar Conta</Button>
        <Button color="inherit" onClick={() => setMenu(3)}>Listar Contas</Button>
      </Toolbar>
    </AppBar>


      { menu == 0 && <ClienteForm></ClienteForm>}
      { menu == 1 && <ClienteTable></ClienteTable>}
      { menu == 2 && <ContaForm></ContaForm>}
      { menu == 3 && <ContaTable></ContaTable>}
      
      
    </>
  )
}

export default App
