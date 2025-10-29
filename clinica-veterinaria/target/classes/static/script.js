document.addEventListener("DOMContentLoaded", () => {
  const path = window.location.pathname;

  // Página de animais
  if (path.includes("animais.html")) {
    const form = document.getElementById("formAnimal");
    const lista = document.getElementById("listaAnimais");

    const carregarAnimais = async () => {
      const resp = await fetch("/animais");
      const dados = await resp.json();
      lista.innerHTML = "";
      dados.forEach(a => {
        const li = document.createElement("li");
        li.textContent = `ID ${a.id} - ${a.nome} (${a.especie}), ${a.idade} anos - Dono: ${a.dono}`;
        lista.appendChild(li);
      });
    };

    form.addEventListener("submit", async (e) => {
      e.preventDefault();
      const animal = {
        nome: document.getElementById("nome").value,
        especie: document.getElementById("especie").value,
        idade: document.getElementById("idade").value,
        dono: document.getElementById("dono").value
      };
      await fetch("/animais", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(animal)
      });
      form.reset();
      carregarAnimais();
    });

    carregarAnimais();
  }

  // Página de consultas
  if (path.includes("consultas.html")) {
    const form = document.getElementById("formConsulta");
    const lista = document.getElementById("listaConsultas");

    const carregarConsultas = async () => {
      const resp = await fetch("/consultas");
      const dados = await resp.json();
      lista.innerHTML = "";
      dados.forEach(c => {
        const li = document.createElement("li");
        li.textContent = `ID ${c.id} - Data: ${c.data} | Descrição: ${c.descricao} | Animal ID: ${c.animalId}`;
        lista.appendChild(li);
      });
    };

    form.addEventListener("submit", async (e) => {
      e.preventDefault();
      const consulta = {
        data: document.getElementById("data").value,
        descricao: document.getElementById("descricao").value,
        animalId: document.getElementById("animalId").value
      };
      await fetch("/consultas", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(consulta)
      });
      form.reset();
      carregarConsultas();
    });

    carregarConsultas();
  }
});
