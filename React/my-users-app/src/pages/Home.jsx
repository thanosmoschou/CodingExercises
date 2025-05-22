import { useEffect, useState } from "react";
import { Link } from 'react-router-dom'

const dummyUsers = [
    { id: 1, name: "Thanos", age: 22 },
    { id: 2, name: "Eleni", age: 22 },
    { id: 3, name: "Makis", age: 24 },
];

function Home() {
    const [users, setUsers] = useState([]); // I set an empty state for the component at the beginning

    useEffect(() => {
        setUsers(dummyUsers);
    }, []); // Only when the component renders for the first time

    return (
        <>
            <div>
                <h1>Users list</h1>
                <ul>
                    {users.map(user => (
                        <li key={user.id}>
                            <Link to={`/profile/${user.id}`}>{user.name}</Link>
                        </li>
                    ))}
                </ul>
            </div>
        </>
    )
}

export default Home;