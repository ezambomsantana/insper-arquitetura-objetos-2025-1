import { useState } from "react"
import { InputText } from "./InputText"



export function ClienteForm({clientes, setClientes}) {

  const [nome, setNome] = useState()
  const [cpf, setCpf] = useState()

  const cadastrar = () => {
    let cliente = {
      'nome': nome,
      'cpf': cpf
    }
    setClientes([...clientes, cliente])
  }

  return <>

    <InputText label={'Nome'} setValue={setNome} />
    <InputText label={'CPF'} setValue={setCpf} ></InputText>
    <button onClick={cadastrar}>Cadastrar</button>
  </>

}
