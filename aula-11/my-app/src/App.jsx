import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { ClienteTable } from './ClienteTable'
import { ClienteForm } from './ClienteForm'
import { ContaTable } from './ContaTable'
import { ContaForm } from './ContaForm'

function App() {

  const [menu, setMenu] = useState(0)




  return (
    <>

      <button onClick={() => setMenu(0)}>Cadastrar Cliente</button>
      <button onClick={() => setMenu(1)}>Listar Cliente</button>
      <button onClick={() => setMenu(2)}>Cadastrar Conta</button>
      <button onClick={() => setMenu(3)}>Listar Contas</button>


      { menu == 0 && <ClienteForm></ClienteForm>}
      { menu == 1 && <ClienteTable></ClienteTable>}
      { menu == 2 && <ContaForm></ContaForm>}
      { menu == 3 && <ContaTable></ContaTable>}
      
      
    </>
  )
}

export default App
