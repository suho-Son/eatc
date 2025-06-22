import { useState } from 'react';
import './App.css';

function App() {
  const [users, setUsers] = useState(null);

  const handleFetch = async () => {
    try {
      const response = await fetch('/api/users');
      if (response.ok) {
        const data = await response.json();
        setUsers(data);
      } else {
        alert('데이터 조회 실패');
      }
    } catch (err) {
      console.error(err);
      alert('오류 발생');
    }
  };

  return (
    <div className="App">
      <button onClick={handleFetch}>데이터 가져오기</button>
      {users && (
        <pre>{JSON.stringify(users, null, 2)}</pre>
      )}
    </div>
  );
}

export default App;
