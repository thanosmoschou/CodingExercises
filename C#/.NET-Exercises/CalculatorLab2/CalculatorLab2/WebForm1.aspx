<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="CalculatorLab2.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body style="background-color: aqua">
    <form id="form1" runat="server">
        <div>
            <h1>Calculator</h1>


        </div>
        <asp:Label ID="Label1" runat="server" Text="Number 1: "></asp:Label>
&nbsp;<asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
        <br />
        <br />
        <asp:Button ID="btnAdd" runat="server" OnClick="btnAdd_Click" Text="+" />
        <asp:Button ID="btnMul" runat="server" Text="*" />
        <asp:Button ID="btnSub" runat="server" Text="-" />
        <asp:Button ID="btnDivide" runat="server" OnClick="btnDivide_Click" Text="/" />
&nbsp;
        <asp:Button ID="clearBtn" runat="server" Text="Clear" />
        <br />
        <br />
        <asp:Label ID="Label2" runat="server" Text="Number 2: "></asp:Label>
&nbsp;<asp:TextBox ID="TextBox2" runat="server"></asp:TextBox>
        <br />
        <br />
        <asp:Label ID="resLabel" runat="server" Text="Result: "></asp:Label>
    </form>
</body>
</html>
