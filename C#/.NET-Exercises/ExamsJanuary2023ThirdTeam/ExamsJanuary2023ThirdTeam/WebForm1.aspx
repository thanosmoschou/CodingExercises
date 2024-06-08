<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="ExamsJanuary2023ThirdTeam.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <h1>Επίδειξη</h1>
            <br />
            <asp:DropDownList ID="coachesDropDownList" runat="server" AutoPostBack="True" OnSelectedIndexChanged="coachesDropDownList_SelectedIndexChanged">
            </asp:DropDownList>
            <br />
            <br />
            <asp:Label ID="teamLabel" runat="server"></asp:Label>
            <br />
            <br />
            <asp:Image ID="teamFlag" runat="server" />
        </div>
    </form>
</body>
</html>
