import { useEffect, useState } from "react"


export function ContaTable() {

    const [contas, setContas] = useState([])
    useEffect(() => {

        fetch('http://localhost:8080/conta', {
            method: 'GET'
        }).then(response => {
            return response.json()
        }).then(data => {
            setContas(data)
        })

    }, [])


    return <table>

        <tbody>
            {contas.map((conta, index) => {
            return <tr key={index}>
                <td>{conta.numeroConta}</td>
                <td>{conta.agencia}</td>
                <td>{conta.principal.nome}</td>
                <td>{conta.principal.cpf}</td>
                </tr>
            })}
        </tbody>
    </table>


}