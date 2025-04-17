

export function ClienteTable({clientes}) {

    return <table>

        <tbody>
            {clientes.map((cliente, index) => {
            return <tr key={index}>
                <td>{cliente.nome}</td>
                <td>{cliente.cpf}</td>
                </tr>
            })}
        </tbody>
    </table>


}