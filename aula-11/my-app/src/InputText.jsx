

export function InputText({label, setValue}) {

   return <p>
     {label}: <input type='text' onChange={e => setValue(e.target.value)}></input>
   </p>

}