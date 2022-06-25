import React, { useState } from "react";
import fiboService from "../services/fiboService";

function Home() {

  const [inputNum, setInputNum] = useState(0);
  const [fiboList, setFiboList] = useState([]);
  const [sortList, setSortList] = useState([]);
  const [errMsg, setErrMsg] = useState("");

  const findData = (e) => {
    e.preventDefault();
    fiboService.getFiboList(inputNum)
      .then(response => {
        setFiboList(response.data.fibonacci);
        setSortList(response.data.sorted);
        setErrMsg("");
        console.log(response.data);
      })
      .catch(e => {
        if(e.response.status == 416){
          setErrMsg("Please input a number from 1 to 100");
          setFiboList([]);
          setSortList([]);
        }
        console.log(e);
      });

  }

  return (
    <div>
      <h1>Fibonacci</h1>
      
        <label htmlFor="inputNumber">Input a number : </label>
        <input type="text" id="inputNumber" value={inputNum} onChange={(e) => setInputNum(e.target.value)} />

        <button onClick={(e) => findData(e)}>Search</button>
      
      <br />
      {errMsg !== "" ? <div style={{color:"red",fontSize:"9px"}}>*{errMsg}</div>:""}
      <br />

      <div>
        <b>Fibonacci Numbers:  </b> <br/>
       {fiboList.length > 0 ? <div>
        {fiboList.map((num, index) => (
          index > 0 ? ((index % 10) !== 0 ? (" , " + num) : <span><br/> {num}</span>  ): num
        ))}</div>:
        ""}</div>

      <br />

      <div><b>Sorted Numbers:  </b>  <br/>
       {sortList.length > 0 ? <div>
        {sortList.map((num, index) => (
          index > 0 ? ((index % 10) !== 0 ? (" , " + num) : <span><br/> {num}</span>  ) : num
        ))}</div>:
        ""}</div>

    </div>
  );
}

export default Home;