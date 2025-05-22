import { useParams } from "react-router-dom";


const dummyUsers = [
    { id: 1, name: "Thanos", age: 22 },
    { id: 2, name: "Eleni", age: 22 },
    { id: 3, name: "Makis", age: 24 },
];

function Profile() {
    const { id } = useParams();
    const user = dummyUsers.find(u => u.id === parseInt(id));

    if (!user)
        return <div>User not found</div>

    return (
        <div>
            <h2>Profile name: {user.name}</h2>
            <p>User age: {user.age}</p>
        </div>
    )
}

export default Profile;