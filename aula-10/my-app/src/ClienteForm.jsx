import { useState } from "react"
import { InputText } from "./InputText"



export function ClienteForm() {

  const [nome, setNome] = useState()
  const [cpf, setCpf] = useState()

  const cadastrar = () => {
    let cliente = {
      'nome': nome,
      'cpf': cpf
    }

    fetch('http://localhost:8080/cliente', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(cliente)
    }).then(response => {
      return response.text()
    }).then(data => {
      alert(data)
    }).catch(error =>
      alert(error)
    )

  }

  return <>

    <InputText label={'Nome'} setValue={setNome} />
    <InputText label={'CPF'} setValue={setCpf} ></InputText>
    <button onClick={cadastrar}>Cadastrar</button>
  </>

}
